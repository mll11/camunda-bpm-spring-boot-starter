/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.spring.boot.starter.property;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.camunda.bpm.spring.boot.starter.property.CamundaBpmProperties.joinOn;

public class HeaderSecurityProperties {

  protected boolean xssProtectionDisabled = false;
  protected String xssProtectionOption;
  protected String xssProtectionValue;

  public Map<String, String> getInitParams() {
    Map<String, String> initParams = new HashMap<>();

    if (xssProtectionDisabled) { // default is false
      initParams.put("xssProtectionDisabled", String.valueOf(xssProtectionDisabled));
    }
    if (StringUtils.isNotBlank(xssProtectionOption)) {
      initParams.put("xssProtectionOption", xssProtectionOption);
    }
    if (StringUtils.isNotBlank(xssProtectionValue)) {
      initParams.put("xssProtectionValue", xssProtectionValue);
    }

    return initParams;
  }

  public boolean isXssProtectionDisabled() {
    return xssProtectionDisabled;
  }

  public void setXssProtectionDisabled(boolean xssProtectionDisabled) {
    this.xssProtectionDisabled = xssProtectionDisabled;
  }

  public String getXssProtectionOption() {
    return xssProtectionOption;
  }

  public void setXssProtectionOption(String xssProtectionOption) {
    this.xssProtectionOption = xssProtectionOption;
  }

  public String getXssProtectionValue() {
    return xssProtectionValue;
  }

  public void setXssProtectionValue(String xssProtectionValue) {
    this.xssProtectionValue = xssProtectionValue;
  }

  @Override
  public String toString() {
    StringJoiner joinedString = joinOn(this.getClass())

      .add("xssProtectionDisabled=" + xssProtectionDisabled)
      .add("xssProtectionOption=" + xssProtectionOption)
      .add("xssProtectionValue=" + xssProtectionValue);

    return joinedString.toString();
  }
}
