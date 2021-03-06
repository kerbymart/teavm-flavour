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
package org.teavm.flavour.regex.automata;

import org.teavm.flavour.regex.core.SetOfChars;

/**
 *
 * @author Alexey Andreev
 */
public class NfaTransition {
    private NfaState source;
    private SetOfChars charSet;
    private int targetIndex = -1;

    NfaTransition(NfaState source) {
        this.source = source;
    }

    public Nfa getAutomaton() {
        return source.getAutomaton();
    }

    public NfaState getSource() {
        return source;
    }

    public SetOfChars getCharSet() {
        return charSet;
    }

    public void setCharSet(SetOfChars charSet) {
        this.charSet = charSet;
    }

    public NfaState getTarget() {
        return targetIndex >= 0 ? getAutomaton().getStates().get(targetIndex) : null;
    }

    public void setTarget(NfaState target) {
        if (target != null && target.getAutomaton() != getAutomaton()) {
            throw new IllegalArgumentException("Can't set target state from another automaton");
        }
        targetIndex = target != null ? target.getIndex() : -1;
    }
}
