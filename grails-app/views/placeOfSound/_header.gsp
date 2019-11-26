<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="http://localhost:8080/home">
        <g:img dir="images" file="logo.png" width="211" height="60" style="border-radius: 25px"/>
    </a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navb">
        <ul class="navbar-nav mr-auto">
            <g:if test="${isAdmin}">
                <li class="nav-item">
                    <a class="nav-link" href="/submit_instrument"><button class="btn btn-success my-sm-0"
                                                                          type="button">Cargar nuevo Instrumento</button>
                    </a>
                </li>
            </g:if>
        </ul>
        <g:if test="${userLogedIn}">
            <a href="${createLink(action: 'signOut')}"><button class="btn btn-success my-sm-0"
                                                               type="button">Logout</button></a>
        </g:if>
        <g:else>
            <a href="http://localhost:8080/users/sign_in" style="margin-right: 10px">
                <button class="btn btn-success my-2 my-sm-0" type="button">Login</button></a>
            <a href="http://localhost:8080/users/sign_up">
                <button class="btn btn-success my-2 my-sm-0" type="button">Sign Up</button></a>
        </g:else>
    </div>
</nav>