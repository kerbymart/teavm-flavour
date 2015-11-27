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
package org.teavm.flavour.mp;

import org.teavm.common.ServiceRepository;
import org.teavm.diagnostics.Diagnostics;
import org.teavm.model.ClassHolder;
import org.teavm.model.ClassReaderSource;

/**
 *
 * @author Alexey Andreev
 */
public interface ProxyGeneratorContext<T> extends ServiceRepository {
    Diagnostics getDiagnostics();

    ClassReaderSource getClassSource();

    ClassLoader getClassLoader();

    void submitClass(ClassHolder cls);

    Emitter<T> getEmitter();

    <S> ReflectClass<S> findClass(Class<S> cls);

    ReflectClass<?> findClass(String name);
}
