/*******************************************************************************
 * Copyright (c) 2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Amazon Software License (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/asl/
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *******************************************************************************/
package com.amazonaws.services.cloudtrail.clientlibrary.interfaces;

import com.amazonaws.services.cloudtrail.clientlibrary.exceptions.CallbackException;
import com.amazonaws.services.cloudtrail.clientlibrary.model.CloudTrailClientRecord;

/**
 * RecordFilter is a call back function that hands a AWSCloudTrailRecord to user. User can determinate whether
 * want to process this record or not. The filter() method is invoked before process records. Records
 * filtered by RecordFilter will hand to RecordsProcessor. For performance, CloudTrailClientRecord is not
 * cloned, caller should not change the content of record.
 */
public interface RecordFilter{

    /**
     * A method filter record.
     *
     * @param record
     * @return true if the record should be processed by AWSCloudTrailClientLibrary.
     * @throws CallbackException when error happened during process CloudTrailClientRecords. AWSCloudTrailClientLibrary
     *         will eventually hand this exception back to ExceptionHandler.
     */
    public boolean filterRecord(CloudTrailClientRecord record) throws CallbackException;

}