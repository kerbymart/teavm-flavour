/*
 *  Copyright 2015 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.flavour.rest.test;

/**
 *
 * @author Alexey Andreev
 */
public class TestServiceImpl implements TestService {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int sum(int mod, int a, int b) {
        int result = a + b % mod;
        if (result < 0) {
            result += mod;
        }
        return result;
    }
}
