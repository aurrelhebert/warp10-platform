//
//   Copyright 2018  SenX S.A.S.
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
//

package io.warp10;

import java.io.IOException;
import java.io.OutputStream;

public class CapacityExtractorOutputStream extends OutputStream {  
  private int capacity;
  
  @Override
  public void write(int b) throws IOException {}
  
  @Override
  public void write(byte[] b) throws IOException {
    synchronized(this) {
      this.capacity = b.length;
    }
  }
  
  @Override
  public void write(byte[] b, int off, int len) throws IOException {
    synchronized(this) {
      this.capacity = b.length;
    }
  }
  
  public synchronized int getCapacity() {
    return this.capacity;
  }
}
