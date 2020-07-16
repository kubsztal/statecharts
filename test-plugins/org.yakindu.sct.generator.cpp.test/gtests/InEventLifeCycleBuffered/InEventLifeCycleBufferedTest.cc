/** Generated by YAKINDU Statechart Tools code generator. */
#include <string>
#include "gtest/gtest.h"
#include "InEventLifeCycleBuffered.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

eventbuffers::InEventLifeCycleBuffered* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class InEventLifeCycleBufferedTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new eventbuffers::InEventLifeCycleBuffered();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			false,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(InEventLifeCycleBufferedTest, InEventLifeCycleBufferedTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r2_C));
	
	statechart->raise_e();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r2_C));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r2_D));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r2_D));
	
	statechart->raise_f();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r1_A));
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r2_C));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r1_B));
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r2_C));
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r1_B));
	
	EXPECT_TRUE(statechart->isStateActive(eventbuffers::InEventLifeCycleBuffered::r2_C));
	
	
}

}

