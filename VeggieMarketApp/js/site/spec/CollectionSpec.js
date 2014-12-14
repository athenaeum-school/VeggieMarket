describe("コレクションテスト", function() {
	var blogList;
	var blog1;

	beforeEach(function(){
		blogList = new BlogList();
		blog1 = new Blog();

	});
	it("spec1", function() {
		expect(blogList.length).toBe(0);
		blogList.add(blog1);
		expect(blogList.length).toBe(1);
		expect(blogList.get(blog1.cid)).toEqual(blog1);

	});

	it("spec2", function() {
		var spy = jasmine.createSpy();
		blogList.on('add',spy);
		blogList.on('change',spy);
		blogList.add({message:'メッセージ',_id:1});
		expect(spy).toHaveBeenCalled();
		var blog2 = blogList.get(1);
		blog2.set('message','変更');
        expect(spy.calls.count()).toBe(2);
		
	});

});
