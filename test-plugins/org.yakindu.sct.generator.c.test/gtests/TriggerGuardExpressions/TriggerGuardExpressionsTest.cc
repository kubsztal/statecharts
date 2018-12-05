
#include "gtest/gtest.h"
#include "TriggerGuardExpressions.h"

#include "sc_timer_service.h"

static TriggerGuardExpressions statechart;


class TriggerGuardExpressionsTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void trueGuard();
	void falseGuard();
	void setTimer(TriggerGuardExpressions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(TriggerGuardExpressions* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static TriggerGuardExpressionsTest * tc;


void TriggerGuardExpressionsTest::SetUp()
{
	triggerGuardExpressions_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &triggerGuardExpressions_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void TriggerGuardExpressionsTest::trueGuard()
{
	triggerGuardExpressions_enter(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&statechart);
	triggerGuardExpressionsIface_set_b(&statechart,true);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_B));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e2(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_B));
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&statechart);
	triggerGuardExpressionsIface_raise_e2(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_B));
}
void TriggerGuardExpressionsTest::falseGuard()
{
	triggerGuardExpressions_enter(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_set_b(&statechart,false);
	triggerGuardExpressionsIface_raise_e1(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e2(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&statechart);
	triggerGuardExpressionsIface_raise_e2(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
}

void TriggerGuardExpressionsTest::setTimer(TriggerGuardExpressions* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void TriggerGuardExpressionsTest::unsetTimer(TriggerGuardExpressions* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(TriggerGuardExpressionsTest, trueGuard) {
	trueGuard();
}
TEST_F(TriggerGuardExpressionsTest, falseGuard) {
	falseGuard();
}


