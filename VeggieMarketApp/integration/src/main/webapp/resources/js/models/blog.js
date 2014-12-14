var app = app || {};

app.Blog = Backbone.Model.extend({

    idAttribute: "blogId",
    validate: function(attrs){
        if(_.is){
            return "入力されていません。";
        }
    },
    
    defaults:{
        title: "",
        message: "なし"
    }
});