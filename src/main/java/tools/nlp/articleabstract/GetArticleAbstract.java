/**
* @author hzyuyongmao
* @version 创建时间：2016年9月8日 下午8:07:52
* 类说明
*/
package tools.nlp.articleabstract;

import java.util.List;

import com.hankcs.hanlp.HanLP;

public class GetArticleAbstract {
	public static List<String> getArticleAbstract(String document) {
		return HanLP.extractSummary(document, 3);
	}

	public static void main(String[] args) {
		String document = "不能直推要么是没听过的人跟着人云亦云，要么就是接受不了薄声，要么就是听过推好的k701而言。实际上我跟你感觉一样，直推听流行已经可以听出有别于其他耳机的味道，特别是女声，而上放后，在声场，结像，乐器分离度，定位等方面确实提升巨大，但是这些提升对于古典音乐而言可谓一个天一个地，但是听流行却不过只是感觉听感提高了一些，不负责任的量化一下，大概直推流行80分，上放90分，而古典直推50分，上放90分这样。";

		List<String> sentenceList = HanLP.extractSummary(document, 3);
		for(String summary:sentenceList){
			System.out.println(summary);
		}
	}
}
