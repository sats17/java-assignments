package com.github.sats17.examples.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.examples.NewsCommentsActions;
import com.github.sats17.model.News;

public class FindMaxCommentOnNewsTest {

	News n1,n2,n3,n4;
	
	@Before
	public void setUp() {
		ArrayList<String> comments = new ArrayList<String>(Arrays.asList(new String[]{"Kaddk","Rada","Zakkas"}));
		ArrayList<String> comments1 = new ArrayList<String>(Arrays.asList(new String[]{"Kaddk","Rada"}));
		n1 = new News("Sats17", "posted", comments);
		n2 = new News("Sats18", "post", comments1);	
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testfindNewsIdByMaxCommentsWithValidInputs() {
		ArrayList<News> data = new ArrayList<News>(Arrays.asList(n1,n2));
		System.out.println(NewsCommentsActions.findNewsIdByMaxComments.apply(data));
	}
	
	
	
}
