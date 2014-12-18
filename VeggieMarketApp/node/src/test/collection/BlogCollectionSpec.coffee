describe 'コレクションテスト', ->
  it 'コレクションにモデルがセットされているか', ->

    blogCollection = new BlogCollection()
    expect(blogCollection.model).toBe Blog