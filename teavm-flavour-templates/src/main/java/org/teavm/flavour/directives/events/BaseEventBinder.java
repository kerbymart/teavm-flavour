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
package org.teavm.flavour.directives.events;

import org.teavm.dom.events.Event;
import org.teavm.dom.events.EventListener;
import org.teavm.dom.html.HTMLElement;
import org.teavm.flavour.templates.Action;
import org.teavm.flavour.templates.BindContent;
import org.teavm.flavour.templates.BindDirectiveName;
import org.teavm.flavour.templates.Renderable;

/**
 *
 * @author Alexey Andreev
 */
public abstract class BaseEventBinder<T extends Event> implements Renderable {
    private HTMLElement element;
    private String eventName;
    private Action action;
    private boolean bound;

    public BaseEventBinder(HTMLElement element) {
        this.element = element;
    }

    @BindDirectiveName
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @BindContent
    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public void render() {
        if (!bound) {
            bound = true;
            element.addEventListener(eventName, clickListener);
        }
    }

    @Override
    public void destroy() {
        if (bound) {
            bound = false;
            element.removeEventListener(eventName, clickListener);
        }
    }

    private EventListener<T> clickListener = new EventListener<T>() {
        @Override
        public void handleEvent(T evt) {
            action.perform();
        }
    };
}