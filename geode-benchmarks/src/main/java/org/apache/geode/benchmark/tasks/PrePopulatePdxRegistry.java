/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.geode.benchmark.tasks;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.Region;
import org.apache.geode.pdx.internal.PeerTypeRegistration;
import org.apache.geode.perftest.Task;
import org.apache.geode.perftest.TestContext;

public class PrePopulatePdxRegistry implements Task {

    private int pdxTypesToCreate = 10000;

    public PrePopulatePdxRegistry() {}

    public PrePopulatePdxRegistry(int pdxTypesToCreate) {
        this.pdxTypesToCreate = pdxTypesToCreate;
    }

    /**
     * This method pre-populates the Pdx TypeRegistry with a number of PdxTypes before the actual benchmark starts
     */
    @Override
    public void run(TestContext context) throws Exception {
        Cache serverCache = (Cache) context.getAttribute("SERVER_CACHE");
        Region pdxRegion = serverCache.getRegion(PeerTypeRegistration.REGION_FULL_PATH);
    }

    public int getPdxTypesToCreate() {
        return pdxTypesToCreate;
    }

    public void setPdxTypesToCreate(int pdxTypesToCreate) {
        this.pdxTypesToCreate = pdxTypesToCreate;
    }
}
