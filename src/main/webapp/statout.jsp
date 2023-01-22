<%-- 
    Document   : statout
    Created on : Jan 16, 2023, 4:57:41 AM
    Author     : polonskiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Statistics</title>
<style>
        h1 {
        text-align: center;
        }

        page {
        width: 600px;
        margin:auto;
        }
        table {
        width: 400px;
        margin: 20px auto;
        }
        input [type=submit] {
        margin: auto;
        }
        .list, .list td, .list th {
        margin: auto;
        border:1px solid black;
        border-collapse: collapse;
        }
        .list td, .list th {
        padding: 10px;
        }
</style>
    </head>
   <body> 
	<h1>Statistics</h1> 
	<table> 
		<tbody> 
			<tr>
                            <td><label for="surname">Min Age:</label></td> 
                            <td>${stat.getMinAge()}</td>
			</tr>       
			<tr>
                            <td><label for="surname">Max Age:</label></td> 
                            <td>${stat.getMaxAge()}</td>
			</tr>   
			<tr> 
                            <td><label for="name">Average Age:</label></td> 
                            <td>${stat.getAverageAge()}</td>
			</tr>                        
			<tr>
                            <td><label for="surname">Popular mail domain:</label></td> 
                            <td>${stat.getPopularMailDomain()}</td>
			</tr>
			<tr>
                            <td><label for="surname">Sumdu Mails:</label></td> 
                            <td>${stat.getSumDUMails()}</td>
			</tr>
		</tbody>
	</table> 
</body> 
    
</html>
