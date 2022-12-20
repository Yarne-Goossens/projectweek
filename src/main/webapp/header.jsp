<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-light navbar-expand-Ig bg-white clean-navbar">
        <div class="container">
            <a href="Controller?command=Home"><img class="mt-2 mb-2" src="/img/watergroep_logo_small.png"  alt="De WaterGroep" width="120" height="100"></a>
            <nav class="navbar-light navbar-expand-md">
                <div class="container-fluid">
                    <div id="navcol-2" class="collapse navbar-collapse">
                        <ul class="navbar-nav">
                            <li class="nav-item" ${param.actual eq 'Home'?"id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px" id="goHome" href="Controller?command=Home">Home</a></li>
                            <li class="nav-item"  ${param.actual eq 'voegToe'?"id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px" href="Controller?command=AddForm">Voeg Toe</a></li>
                            <li class="nav-item" ${param.actual eq 'Overzicht'?"id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px" href="Controller?command=Overview">Overzicht Lekken</a></li>
                            <li class="nav-item" ${param.actual eq 'Verstuur Email' ? "id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px" href="Controller?command=SendEmailform">Verstuur Email</a></li>
                            <li class="nav-item" ${param.actual eq 'ShowPDF' ? "id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px" href="Controller?command=CreatePDF">PDF maken</a></li>
                            <li class="nav-item" ${param.actual eq 'Login' ? "id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px" href="Controller?command=LogInPage">Login</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </nav>
</header>