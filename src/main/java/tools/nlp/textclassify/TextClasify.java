/**
* @author hzyuyongmao
* @version 创建时间：2016年9月8日 下午6:37:51
* 类说明
*/
package tools.nlp.textclassify;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class TextClasify {
	private static final Set<String> KAIFA = ImmutableSet.of("面向对象", "Java", "封装", "抽象", "继承", "多态", "抽象类", "父类", "属性",
			"实例", "方法");
	private static final Set<String> DATAMINING = ImmutableSet.of("数据挖掘", "机器学习", "算法", "K-Means", "SVM", "PageRank",
			"最大期望", "AdaBoost", "迭代算法", "K最近邻", "KNN", "分类", "聚类", "过拟合", "欠拟合", "线性回归", "交叉验证", "损失函数", "贝叶斯", "决策树",
			"马尔科夫");
	private static final Set<String> NLP = ImmutableSet.of("分词", "词性标注", "实体词", "语料库", "词库", "词袋模型", "情感分析", "自动摘要",
			"关键词提取");

	private static final Set<String> FRONTEND = ImmutableSet.of("JS", "HTML", "CSS", "JavaScript", "闭包", "ajax",
			"jQuery", "Bootstrap", "前端");

	public static Map<String, Float> getClassfiy(String text) {
		Map<String, Float> map = new HashMap<String, Float>();
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;

		for (String kaifa : KAIFA) {
			if (text.toLowerCase().contains(kaifa.toLowerCase())) {
				a++;
			}
		}
		for (String dm : DATAMINING) {
			if (text.toLowerCase().contains(dm.toLowerCase())) {
				b++;
			}
		}
		for (String nlp : NLP) {
			if (text.toLowerCase().contains(nlp.toLowerCase())) {
				c++;
			}
		}

		for (String ft : FRONTEND) {
			if (text.toLowerCase().contains(ft.toLowerCase())) {
				d++;
			}
		}
		int sum = a + b + c + d;
		float rateA = 0;
		float rateB = 0;
		float rateC = 0;
		float rateD = 0;
		if (sum != 0) {
			rateA = a / sum;
			rateB = b / sum;
			rateC = c / sum;
			rateD = d / sum;
		}
		map.put("后端开发", rateA);
		map.put("数据挖掘", rateB);
		map.put("自然语言处理", rateC);
		map.put("前端开发", rateD);
		return map;

	}

	public static void main(String args[]) {
		String text = "在CSS布局时需要注意的一个问题是很多同学缺乏对页面布局进行整体分析，不能够从宏观上对页面中盒子间的嵌套关系进行把握，就急于动手去做，导致页面中各元素间的关系很混乱，容易出现盒子在浮动时错位等情况。建议大家在布局时采用“自顶向下，逐步细化”的思想，先用几个盒子将页面从整体上划分，然后逐步在盒子中继续嵌套盒子。";
		Map<String, Float> map = getClassfiy(text);
		System.out.println(map.toString());

	}
}
