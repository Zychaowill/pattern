package com.jangz.ex.collection;

import java.util.ArrayList;
import java.util.List;

import com.jangz.ex.entity.Article;

public class CollectionDemo {
	
	private List<Article> articles = new ArrayList<>();
	
	public static void main(String[] args) {
		CollectionDemo demo = new CollectionDemo();
		demo.initData();
		System.out.println(demo.getAllJavaArticle());
	}
	
	public void initData() {
		List<String> tags = new ArrayList<>();
		tags.add("Java");
		tags.add("Linux");
		
		articles.add(new Article("Head First Java", "Jang", tags));
		articles.add(new Article("Head First ���ģʽ", "Jang", tags));
		articles.add(new Article("�����Linux˽����", "Jang", tags));
		articles.add(new Article("Java��ģʽ", "Zychao", tags));
	}
	
	public List<Article> getAllJavaArticle() {
		List<Article> result = new ArrayList<>();
		
		for (Article article : articles) {
			if (article.getTags().contains("Java")) {
				result.add(article);
			}
		}
		return result;
	}
}
