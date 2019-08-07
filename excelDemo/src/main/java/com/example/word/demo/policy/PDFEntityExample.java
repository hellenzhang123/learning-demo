package com.example.word.demo.policy;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.DocxRenderData;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.example.word.demo.entity.Order;
import com.example.word.demo.entity.OrderData;
import com.example.word.demo.entity.PDFEntity;
import com.example.word.demo.entity.SegmentData;
import com.example.word.demo.entity.StoryData;

public class PDFEntityExample {

	List<OrderData> orderDatas = new ArrayList<>();
	List<Order> orderList = new ArrayList<>();
	@Before
    public void init(){
		Order o1 = new Order();
		o1.setName("商品1");
		o1.setAmount("100");
		o1.setForegift("101");
		o1.setPrice("20");
		o1.setTotal("2000");
		o1.setSpec("small");
		Order o2 = new Order();
		o2.setName("商品2");
		o2.setAmount("200");
		o2.setForegift("102");
		o2.setPrice("20");
		o2.setTotal("4000");
		o2.setSpec("m");
		Order o3 = new Order();
		o3.setName("商品3");
		o3.setAmount("300");
		o3.setForegift("103");
		o3.setPrice("20");
		o3.setTotal("6000");
		o3.setSpec("l");
        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);
        OrderData orderData = new OrderData();
		orderData.setStoreNo("88102991299");
		orderData.setStoreArea("1000");
		orderData.setStroreName("酸酸的店");
		List<RowRenderData> list = new ArrayList<>();
		for (Order order : orderList) {
			RowRenderData data = new RowRenderData();
			
			List<TextRenderData> textList = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				TextRenderData textRenderData = new TextRenderData();
				textRenderData.setText(order.getAmount());
				textList.add(textRenderData);
				TextRenderData textRenderData1 = new TextRenderData();
				textRenderData1.setText(order.getForegift());
				textList.add(textRenderData1);
				TextRenderData textRenderData2 = new TextRenderData();
				textRenderData2.setText(order.getName());
				textList.add(textRenderData2);
				TextRenderData textRenderData3 = new TextRenderData();
				textRenderData3.setText(order.getPrice());
				textList.add(textRenderData3);
				TextRenderData textRenderData4 = new TextRenderData();
				textRenderData4.setText(order.getSpec());
				textList.add(textRenderData4);
				TextRenderData textRenderData5 = new TextRenderData();
				textRenderData5.setText(order.getTotal());
				textList.add(textRenderData5);
			}
			data.setRowData(textList);
			list.add(data);
			
		}
		MiniTableRenderData data = new MiniTableRenderData(list);
		orderData.setOrderList(data);
		
		OrderData orderData1 = new OrderData();
		orderData1.setStoreNo("777661728212");
		orderData1.setStoreArea("1001");
		orderData1.setStroreName("酸酸的店1");
		orderData1.setOrderList(data);
		
		OrderData orderData2 = new OrderData();
		orderData2.setStoreNo("998716252113");
		orderData2.setStoreArea("1002");
		orderData2.setStroreName("酸酸的店2");
		orderData2.setOrderList(data);
    }

	
	@Test
    public void testStoryExample() throws Exception {
		PDFEntity entity = new PDFEntity();
		
        
        DocxRenderData segment = new DocxRenderData(new File("src/test/resources/order.docx"), orderDatas );
        entity.setBank("深圳建行");
        entity.setAccount("37482743");
        entity.setBuyer("酸");
        entity.setCompanyName("酸的公司");
        entity.setOrder(segment);
        entity.setOrderBy("hhshhs");
        entity.setOrderDate(new Date());
        entity.setPrintDate(new Date());
        entity.setRemitcode("3849asdaf");
        entity.setRemitTotal(10000);

        XWPFTemplate template = XWPFTemplate.compile("src/test/resources/default_payment.docx").render(entity);

        FileOutputStream out = new FileOutputStream("out_story.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();

    }
}
