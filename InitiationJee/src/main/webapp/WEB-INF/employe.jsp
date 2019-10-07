<%@ page isELIgnored ="false" contentType = "text/html;charset=UTF-8" language="java"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap Login Form</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
  <style type="text/css">
     body{background-color: #f1f1f1;}
     .bslf{
    width: 350px;
  margin: 120px auto;
  padding: 25px 20px;
  background: #3a1975;
  box-shadow: 2px 2px 4px #ab8de0;
  border-radius: 5px;
  color: #fff;
     }
     .bslf h2{
    margin-top: 0px;
  margin-bottom: 15px;
  padding-bottom: 5px;
  border-radius: 10px;
  border: 1px solid #25055f;
     }
     .bslf a{color: #783ce2;}
     .bslf a:hover{
    text-decoration: none;
      color: #03A9F4;
     }
     .bslf .checkbox-inline{padding-top: 7px;}
  </style>
</head>
<body>
  <div class="bslf">
    <form action="" method="post">
      <h2 class="text-center">Add Employe</h2>
      <div class="form-group">
        <input type="text" name="matricule" class="form-control" placeholder="matricule" required="required">
      </div>
      <div class="form-group">
        <input type="text" name="nom" class="form-control" placeholder="nom" required="required">
      </div>
      <div class="form-group">
         <input type="number" name="telephone" class="form-control" placeholder="Telephone" required="required">
       </div>
      <div class="form-group">
        <input type="text" name="adresse" class="form-control" placeholder="adresse" required="required">
      </div>
      <div class="form-group">
        <input type="date" name="date_naissance" class="form-control" required="required">
      </div>
       <div class="form-group">
        <input type="text" name="salaire" class="form-control" placeholder="Salaire" required="required">
       </div>
     <div class="form-group">
         <select name="service" class="form-control">
         <option value="" disabled selected>Select Service</option>
             <c:forEach items="${service}" var="s">
                <option value="${s.id}">${s.lib}</option>
             </c:forEach>
         </select>
     </div>
      <div class="form-group clearfix">
        <button type="submit" class="btn btn-primary pull-right">Add</button>
      </div>
      <div class="clearfix">
        <a href="#" class="pull-left">Forgot Password?</a>
        <a href="#" class="pull-right">Create an Account</a>
      </div>
    </form>
    ${request.error}
  </div>

  <table class=table>
   <tr>
        <td>Matricule</td>
        <td>Nom</td>
        <td>Telephone</td>
        <td>Adresse</td>
        <td>Date Date naissance</td>
        <td>Salaire</td>
        <td>Service</td>
        <td>Modifier</td>
   </tr>
  <c:forEach items="${employe}" var="e">
    <tr>
     <td>${e.matricule}</td>
     <td>${e.nom}</td>
     <td>${e.telephone}</td>
     <td>${e.adresse}</td>
     <td>${e.date_naissance}</td>
     <td>${e.salaire}</td>
     <td>${e.service.lib}</td>
     <td><a href="${pageContext.request.contextPath}/employe?action=edit&id=${e.id}" class="btn btn-primary"><i class="fas fa-edit"></i></a></td>
    </tr>
  </c:forEach>
  </table>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>