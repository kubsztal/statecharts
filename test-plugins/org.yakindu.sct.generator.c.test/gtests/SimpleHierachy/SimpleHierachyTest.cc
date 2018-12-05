
#include "gtest/gtest.h"
#include "SimpleHierachy.h"

#include "sc_timer_service.h"

static SimpleHierachy statechart;


class SimpleHierachyTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void simpleHierachyTest();
	void setTimer(SimpleHierachy* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(SimpleHierachy* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static SimpleHierachyTest * tc;


void SimpleHierachyTest::SetUp()
{
	simpleHierachy_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &simpleHierachy_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void SimpleHierachyTest::simpleHierachyTest()
{
	simpleHierachy_enter(&statechart);
	EXPECT_TRUE(simpleHierachy_isStateActive(&statechart, SimpleHierachy_main_region_A));
	simpleHierachyIface_raise_event1(&statechart);
	simpleHierachyIface_raise_event1(&statechart);
	simpleHierachyIface_raise_event1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(simpleHierachy_isStateActive(&statechart, SimpleHierachy_main_region_B));
	EXPECT_TRUE(simpleHierachy_isStateActive(&statechart, SimpleHierachy_main_region_B_subregion1_B1));
}

void SimpleHierachyTest::setTimer(SimpleHierachy* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void SimpleHierachyTest::unsetTimer(SimpleHierachy* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(SimpleHierachyTest, simpleHierachyTest) {
	simpleHierachyTest();
}


