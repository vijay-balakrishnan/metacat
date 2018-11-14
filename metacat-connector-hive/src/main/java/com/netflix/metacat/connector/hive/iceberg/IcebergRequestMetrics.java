/*
 *  Copyright 2018 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */


package com.netflix.metacat.connector.hive.iceberg;

import lombok.Getter;

/**
 * Iceberg Metrics.
 *
 * @author zhenl
 * @since 1.2.0
 */
@Getter
public enum IcebergRequestMetrics {

    /**
     * Timer.
     */
    TimerIcebergRequest(IcebergRequestMetrics.Type.timer, "iceberg.requests"),

    /**
     * Tag of loadTable operation.
     */
    TagLoadTable("loadTable"),

    /**
     * Tag of getPartitionMap operation.
     */
    TagGetPartitionMap("getPartitionMap");

    enum Type {
        counter,
        gauge,
        timer
    }

    private final String metricName;

    IcebergRequestMetrics(final IcebergRequestMetrics.Type type, final String measure) {
        this.metricName = String.format("metacat.iceberg.%s.%s.%s", type.name(), type.name(), measure);
    }

    IcebergRequestMetrics(final String name) {
        this.metricName = name;
    }

    @Override
    public String toString() {
        return metricName;
    }
}