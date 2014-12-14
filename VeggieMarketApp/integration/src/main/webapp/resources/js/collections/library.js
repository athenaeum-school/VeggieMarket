var app = app || {};

app.Library = Backbone.Collection.extend({
    model: app.Blog,
    url:"http://localhost:8080/security/json/"
});