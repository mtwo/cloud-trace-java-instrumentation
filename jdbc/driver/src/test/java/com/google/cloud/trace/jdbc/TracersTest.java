// Copyright 2016 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.cloud.trace.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;

import com.google.cloud.trace.Tracer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** *  Unit tests for {@link Tracers}. */
@RunWith(JUnit4.class)
public class TracersTest {
  private final Tracer mockTracer = mock(Tracer.class);

  @Test
  public void getCurrent_threadlocal() {
    ThreadLocalTracerStore.setCurrent(mockTracer);
    Tracer tracer = new Tracers().getCurrent();
    assertThat(tracer).isSameAs(mockTracer);
    ThreadLocalTracerStore.remove();
  }
}
