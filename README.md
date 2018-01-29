# openeyes-server-war
Backend server between BI tool and openeyes database


Example Client Usage:

Endpoint:
http://localhost:9080/openeyes-server-war/QueryServlet

Headers:
Content-Type:application/json

Body EXAMPLE 1  [JSON (application/json)]:
{

   "queryAction":"GetPatientByID",

   "queryParams" : [17885],

   "queryType" : "Fetch"

}

Body EXAMPLE 2  [JSON (application/json)]:
{

   "queryAction":"GetAllPatients",

   "queryParams" : [],
   "queryType" : "Fetch"

}
