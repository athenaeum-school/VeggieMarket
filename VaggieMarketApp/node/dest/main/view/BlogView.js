var BlogView,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

BlogView = (function(_super) {
  __extends(BlogView, _super);

  function BlogView() {
    return BlogView.__super__.constructor.apply(this, arguments);
  }

  BlogView.prototype.tagName = 'div';

  BlogView.prototype.className = 'blogContainer';

  BlogView.prototype.template = _.template($('#blogtemplate').html());

  BlogView.prototype.render = function() {
    this.$el.html(this.template(this.model.toJSON()));
    return this;
  };

  return BlogView;

})(Backbone.View);
