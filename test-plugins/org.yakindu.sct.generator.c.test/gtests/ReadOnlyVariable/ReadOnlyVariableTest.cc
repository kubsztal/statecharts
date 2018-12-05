
#include "gtest/gtest.h"
#include "ReadOnlyVariable.h"

#include "sc_timer_service.h"

static ReadOnlyVariable statechart;


class ReadOnlyVariableTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void readOnlyVariableTest();
	void setTimer(ReadOnlyVariable* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ReadOnlyVariable* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ReadOnlyVariableTest * tc;


void ReadOnlyVariableTest::SetUp()
{
	readOnlyVariable_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &readOnlyVariable_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void ReadOnlyVariableTest::readOnlyVariableTest()
{
	readOnlyVariable_enter(&statechart);
	EXPECT_TRUE(readOnlyVariable_isStateActive(&statechart, ReadOnlyVariable_main_region_StateA));
	EXPECT_TRUE(readOnlyVariableIface_get_myInt(&statechart)== 0l);
	EXPECT_TRUE(strcmp(readOnlyVariableIface_get_myString(&statechart), "testString") == 0);
	EXPECT_TRUE(readOnlyVariableIface_get_myBool(&statechart)== true);
	EXPECT_TRUE(readOnlyVariableIface_get_myReal(&statechart)== 1.1);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myInt(&statechart) == 0l);
	EXPECT_TRUE(strcmp(readOnlyVariableIfaceA_get_myString(&statechart) , "testString") == 0);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myBool(&statechart) == true);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myReal(&statechart) == 1.1);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(readOnlyVariable_isStateActive(&statechart, ReadOnlyVariable_main_region_StateB));
	EXPECT_TRUE(readOnlyVariableIface_get_myInt(&statechart)== 100l);
	EXPECT_TRUE(strcmp(readOnlyVariableIface_get_myString(&statechart), "fail") == 0);
	EXPECT_TRUE(readOnlyVariableIface_get_myBool(&statechart)== false);
	EXPECT_TRUE(readOnlyVariableIface_get_myReal(&statechart)== 6.6);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myInt(&statechart) == 200l);
	EXPECT_TRUE(strcmp(readOnlyVariableIfaceA_get_myString(&statechart) , "A_fail") == 0);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myBool(&statechart) == false);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myReal(&statechart) == 7.7);
}

void ReadOnlyVariableTest::setTimer(ReadOnlyVariable* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ReadOnlyVariableTest::unsetTimer(ReadOnlyVariable* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ReadOnlyVariableTest, ReadOnlyVariableTest) {
	readOnlyVariableTest();
}


