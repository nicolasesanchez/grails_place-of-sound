<head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css">
</head>

<div class="wrapper fadeInDown">
  <div id="formContent">
    
    <!-- Logo -->
    <div class="fadeIn first">
      %{--      <img src="logo.png" id="icon" alt="User Icon" />--}%
      <g:img dir="images" file="logo.png" width="211" height="63"/>
    </div>

    <!-- Campos login -->
    <g:form method="POST" url="/users/sign_in">
      <input type="text" name="userName" id="login" class="fadeIn second" name="login" placeholder="login">
      <input type="text" name="password" id="password" class="fadeIn third" name="login" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </g:form>

    <!-- Registrar usuario -->
    <div id="formFooter">
      <a class="underlineHover" href="/users/sign_up" action >Register</a>
%{--    <g:createLink url="/user/sign_in" action="POST" namespace="Register" />--}%
    </div>

  </div>
</div>