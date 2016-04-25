
# Sample query sheet for retrieving telecom data from DB

USE TelecomProjectSQL;

# To get all base and event data use left join so null values are included
# Join on event id and cause code to avoid cartesian product style result
SELECT Base_Data_Id, base_data.Event_Id, base_data.Cause_Code,  Description
FROM base_data LEFT JOIN event_cause
ON base_data.Event_Id = event_cause.Event_Id
AND base_data.Cause_Code = event_cause.Cause_Code;

# To get all failure events and descriptions from base data and failure class table
# Use left join to avoid losing rows with null values
SELECT Base_Data_Id, Date_Time, base_data.Failure_Class, Description
FROM base_data LEFT JOIN failure_class
ON base_data.Failure_Class = failure_class.Failure_Class_Id
ORDER BY Base_Data_Id;
