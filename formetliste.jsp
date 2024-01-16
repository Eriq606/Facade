<div class="container-fluid pt-4 px-4">
    <div class="row g-4">
        <div class="col-sm-12 col-xl-6">
            <div class="bg-secondary rounded h-100 p-4">
                <h6 class="mb-4">Form et liste</h6>
                <form action="" method="">
<div class="mb-3">
    <label for="nominput" class="form-label">Nom</label>
    <input type="text" class="form-control" id="nominput"
        aria-describedby="nomhelp" name="nom">
    <div id="nomhelp" class="form-text">Votre nom restera confidentiel
    </div>
</div>

<div class="form-floating mb-3">
    <select class="form-select" id="embaucheSelect"
        aria-label="" name="embauche">
        <option selected>All</option>
    </select>
    <label for="embaucheSelect">Embauche</label>
</div>

<div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="marriedcheck" name="married">
    <label class="form-check-label" for="marriedcheck">Est marie</label>
</div>


                <input type="submit" value="Valider">
                </form>
            </div>
        </div>
        <div class="col-sm-12 col-xl-6">
            <div class="bg-secondary rounded h-100 p-4">
                <h6 class="mb-4">Form et liste</h6>
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
                        <% for(depart.work.Emp o:liste){ %>
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
