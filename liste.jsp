<%
    Emp[] liste=(Emp[])request.getAttribute("objects");
%>
<div class="container-fluid pt-4 px-4">
    <div class="row g-4">
        <div class="col-sm-12 col-xl-6">
            <div class="bg-secondary rounded h-100 p-4">
                <h6 class="mb-4">Lister</h6>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nom</th>

<th scope="col">Salaire</th>

<th scope="col">Embauche</th>

<th scope="col">Est marie</th>


                        </tr>
                    </thead>
                    <tbody>
                        <% for(Emp o:liste){ %>
                            <tr>
                                <td><%= o.getNom() %></td>

<td><%= o.getSalaire() %></td>

<td><%= o.getEmbauche() %></td>

<td><%= o.getMarried() %></td>


                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
