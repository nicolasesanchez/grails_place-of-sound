<g:render template="header" model="[userLogedIn: logedIn, isAdmin: isAdmin]"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <span class="navbar-brand">Filters</span>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <g:each var="category" in="${categories}">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <g:select class="custom-select" name="category" from="${category.children}"
                              optionKey="id" optionValue="name"
                              noSelection="[(category.id): category.name]"/>
                </li>
            </ul>
        </g:each>
    </div>
</nav>
<br>
<br>


<g:each var="instrumentNode" in="${instrumentsList}">
    <div class="card-deck">
        <g:each var="instrument" in="${instrumentNode}">
            <div class="card">
                <img src="${createLink(controller: "PlaceOfSound", action: "getInstrumentPicture", id: instrument.id)}"
                     width="300" height="300"/>

                <div class="card-body">
                    <h2 class="card-title">Título: ${instrument.title}</h2>
                    <h5 class="card-price">Precio: $${instrument.price}</h5>
                </div>
            </div>
        </g:each>
    </div>
    <br>
    <br>
</g:each>