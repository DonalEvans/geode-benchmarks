#!/bin/bash
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

baseDir=~/benchmarking/GEODE-8950
resultsFile=$baseDir/1.13_1-vs-$1.txt

for i in {1..10} ; do
  /bin/bash /Users/doevans/workspace/geode-benchmarks/infrastructure/scripts/aws/analyze_tests.sh --baseline $baseDir/1.13/GEODE-8950-1.13-1/ --branch $baseDir/$1/$1-$i/ >> $resultsFile
done

$(grep -A 12 "Comparing test result at" $resultsFile > tmp && sed -E 's/ {2,}/	/g' tmp | sed -E 's/e: /e:	/g' | sed -E 's/t: /t:	/g' > $baseDir/tmp.txt && rm tmp)

