/** Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "OutEventVisibilityEventDriven.h"

#include "sc_timer_service.h"

static OutEventVisibilityEventDriven statechart;


class OutEventVisibilityEventDrivenTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void out_events_must_be_collected_during_local_event_processing_steps();
	void all_out_events_that_are_raised_within_a_single_step_must_be_visible();
	void setTimer(OutEventVisibilityEventDriven* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(OutEventVisibilityEventDriven* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static OutEventVisibilityEventDrivenTest * tc;


void OutEventVisibilityEventDrivenTest::SetUp()
{
	outEventVisibilityEventDriven_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &outEventVisibilityEventDriven_runCycle,
		true,
		200,
		&statechart
	);
	
	
	tc = this;
}
void OutEventVisibilityEventDrivenTest::out_events_must_be_collected_during_local_event_processing_steps()
{
	outEventVisibilityEventDriven_enter(&statechart);
	outEventVisibilityEventDrivenIface_raise_i(&statechart, 1);
	EXPECT_TRUE(outEventVisibilityEventDrivenIface_israised_o1(&statechart));
	EXPECT_TRUE(outEventVisibilityEventDrivenIface_israised_o2(&statechart));
	outEventVisibilityEventDriven_exit(&statechart);
}
void OutEventVisibilityEventDrivenTest::all_out_events_that_are_raised_within_a_single_step_must_be_visible()
{
	outEventVisibilityEventDriven_enter(&statechart);
	EXPECT_TRUE(!outEventVisibilityEventDrivenIface_israised_o1(&statechart));
	EXPECT_TRUE(!outEventVisibilityEventDrivenIface_israised_o2(&statechart));
	outEventVisibilityEventDrivenIface_raise_i(&statechart, 2);
	EXPECT_TRUE(outEventVisibilityEventDrivenIface_israised_o1(&statechart));
	EXPECT_TRUE(!outEventVisibilityEventDrivenIface_israised_o2(&statechart));
	outEventVisibilityEventDrivenIface_raise_i(&statechart, 2);
	EXPECT_TRUE(!outEventVisibilityEventDrivenIface_israised_o1(&statechart));
	EXPECT_TRUE(outEventVisibilityEventDrivenIface_israised_o2(&statechart));
	outEventVisibilityEventDrivenIface_raise_i(&statechart, 2);
	EXPECT_TRUE(outEventVisibilityEventDrivenIface_israised_o1(&statechart));
	EXPECT_TRUE(outEventVisibilityEventDrivenIface_israised_o2(&statechart));
	outEventVisibilityEventDriven_exit(&statechart);
}

void OutEventVisibilityEventDrivenTest::setTimer(OutEventVisibilityEventDriven* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void OutEventVisibilityEventDrivenTest::unsetTimer(OutEventVisibilityEventDriven* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(OutEventVisibilityEventDrivenTest, out_events_must_be_collected_during_local_event_processing_steps) {
	out_events_must_be_collected_during_local_event_processing_steps();
}
TEST_F(OutEventVisibilityEventDrivenTest, all_out_events_that_are_raised_within_a_single_step_must_be_visible) {
	all_out_events_that_are_raised_within_a_single_step_must_be_visible();
}


