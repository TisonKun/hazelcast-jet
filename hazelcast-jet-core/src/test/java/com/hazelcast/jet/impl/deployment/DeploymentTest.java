/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.jet.impl.deployment;

import com.hazelcast.internal.util.FilteringClassLoader;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.jet.config.JetConfig;
import com.hazelcast.test.HazelcastSerialClassRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static java.util.Collections.singletonList;

@RunWith(HazelcastSerialClassRunner.class)
public class DeploymentTest extends AbstractDeploymentTest {

    @BeforeClass
    public static void beforeClass() {
        JetConfig jetConfig = new JetConfig();
        FilteringClassLoader filteringClassLoader = new FilteringClassLoader(singletonList("deployment"), null);
        jetConfig.getHazelcastConfig().setClassLoader(filteringClassLoader);

        initialize(2, jetConfig);
    }

    @Override
    protected JetInstance getJetInstance() {
        return instance();
    }
}
