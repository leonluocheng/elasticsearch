/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.ccr.action;

import org.elasticsearch.test.AbstractStreamableTestCase;
import org.elasticsearch.xpack.core.ccr.AutoFollowStats;
import org.elasticsearch.xpack.core.ccr.action.FollowStatsAction;
import org.elasticsearch.xpack.core.ccr.action.StatsAction;

import static org.elasticsearch.xpack.ccr.action.AutoFollowStatsTests.randomReadExceptions;
import static org.elasticsearch.xpack.ccr.action.StatsResponsesTests.createStatsResponse;

public class AutoFollowStatsResponseTests extends AbstractStreamableTestCase<StatsAction.Response> {

    @Override
    protected StatsAction.Response createBlankInstance() {
        return new StatsAction.Response();
    }

    @Override
    protected StatsAction.Response createTestInstance() {
        AutoFollowStats autoFollowStats = new AutoFollowStats(
            randomNonNegativeLong(),
            randomNonNegativeLong(),
            randomNonNegativeLong(),
            randomReadExceptions()
        );
        FollowStatsAction.StatsResponses statsResponse = createStatsResponse();
        return new StatsAction.Response(autoFollowStats, statsResponse);
    }
}
