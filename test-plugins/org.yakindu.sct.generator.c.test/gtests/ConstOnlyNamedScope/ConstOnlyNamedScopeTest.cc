
#include "gtest/gtest.h"
#include "ConstOnlyNamedScope.h"

#include "sc_timer_service.h"

static ConstOnlyNamedScope statechart;


class ConstOnlyNamedScopeTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void statechartEntry();
	void stateTransition();
	void setTimer(ConstOnlyNamedScope* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ConstOnlyNamedScope* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ConstOnlyNamedScopeTest * tc;


void ConstOnlyNamedScopeTest::SetUp()
{
	constOnlyNamedScope_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &constOnlyNamedScope_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ConstOnlyNamedScopeTest::statechartEntry()
{
	constOnlyNamedScope_enter(&statechart);
	EXPECT_TRUE(constOnlyNamedScope_isStateActive(&statechart, ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_A));
}
void ConstOnlyNamedScopeTest::stateTransition()
{
	constOnlyNamedScope_enter(&statechart);
	constOnlyNamedScopeIface_raise_e(&statechart, 1l);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(constOnlyNamedScope_isStateActive(&statechart, ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_B));
}

void ConstOnlyNamedScopeTest::setTimer(ConstOnlyNamedScope* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ConstOnlyNamedScopeTest::unsetTimer(ConstOnlyNamedScope* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ConstOnlyNamedScopeTest, statechartEntry) {
	statechartEntry();
}
TEST_F(ConstOnlyNamedScopeTest, stateTransition) {
	stateTransition();
}


