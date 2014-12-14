var app = app || {};

app.BlogView = Backbone.View.extend({
    tagName : "div",
    className : "blogContainer",

    events : {
        "click .delete" : "deleteBlog",
        "dblclick label" : "edit",
        "keypress .message" : "updateOnEnter",
        "blur .message": "close"
    },

    initialize : function() {
        _.templateSettings = {
            interpolate : /\{\{(.+?)\}\}/g
        };
        this.listenTo(this.model,"change",this.render);
    },

    render : function() {

        var template = _.template($("#blogTemplate").html());
        this.$el.html(template(this.model.toJSON()));
        return this;
    },

    deleteBlog : function() {
        this.model.destroy();
        this.remove();
    },

    edit : function() {
        this.$input = this.$(".message");
        this.$el.addClass("editing");
        this.$input.css("display", "block");
        this.$input.focus();
    },

    updateOnEnter : function(e) {
        if (e.which === 13) {
            this.close();

        }
    },

    close: function(){
        var value = this.$(".message").val();
        this.model.save({
            message : value
        });

        this.$el.removeClass("editing");
        this.input = this.$(".message");
        this.input.css("display", "none");

    }

});