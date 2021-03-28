package com.github.sats17.streams.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.github.sats17.streams.model.News;

public class NewsCommentsActions {

	public static Function<ArrayList<News>, Integer> findNewsIdByMaxComments = news -> {

		News newsObj = news.stream().max((News f1, News f2) -> {
			return Integer.compare(f1.getComment().size(), f1.getComment().size());
		}).get();

		return newsObj.getNewsId();
	};
	
	public static BiFunction<ArrayList<News>, String, Integer> findNumberOfWordInComments = (news,word) -> {
		
		
//		int count = 0;
//		 news.stream()
//			.filter(newsObj -> newsObj.getComment() != null)
//			.map(mapper -> mapper.getComment())
//			.forEach(listNews -> {
//				Optional<String> s = listNews.stream()
//						.findAny();	
//				if(s.isPresent())
//					count++;
//			});
//		
		
		
		return null;
		
	};

}
