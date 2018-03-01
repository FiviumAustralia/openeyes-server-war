# openeyes-server-war
Backend server between BI tool and openeyes database


Example Client Usage:

Endpoint:
```
http://localhost:9080/openeyes-server-war/QueryServlet
```
Headers:
```
Content-Type:application/json
```
Body EXAMPLE 1 (Select all injections)  [JSON (application/json)]:
```
{
  "queryAction":"{\"Injections\":[\"Inject Batch Expiry\",\"Injection Batch\",\"Injection Number\"]}",
  "queryParams":[],
  "queryType":"Fetch"
}
```

Body EXAMPLE 2 (Select all from Injections and Patients [JSON (application/json)]:
```
{
  "queryAction":"{\"Injections\":[\"Inject Batch Expiry\",\"Injection Batch\",\"Injection Number\"],\"Patients\":[\"Patient Deceased?\",\"Deceased Date\",\"NHS Number\",\"Hospital Number\",\"Gender\",\"Date of Birth\",\"Maiden Name\",\"Last Name\",\"First Name\",\"Title\",\"Preferred Name\"]}",
  "queryParams":[],
  "queryType":"Fetch"
}
```