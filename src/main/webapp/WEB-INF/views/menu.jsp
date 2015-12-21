<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <spring:message code="label.admin" var="admin"/>
    <spring:message code="label.home" var="home"/>
    <nav>
        <nav class="navbar navbar-default">
            <ul class="nav navbar-nav">
                <li><a href="/index">${home}</a></li>
                <li class="active"><a href="/about/">About us</a></li>
                <li><a href="/service"> ${admin}</a></li>
                <li><a href="/partners/">Partners</a></li>
                <li><a href="/customers/">Customers</a></li>
                <li><a href="/projects/">Projects</a></li>
                <li><a href="/careers/">Careers</a></li>
                <li><a href="/contact/">Contact</a></li>
            </ul>
        </nav>
    </nav>

