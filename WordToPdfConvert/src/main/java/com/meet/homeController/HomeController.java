package com.meet.homeController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class HomeController {

	@RequestMapping("/")
	public String findPage() {
		System.out.println("coming to main page");
		return "HomePage";
	}

	@PostMapping("/goToNextPage")
	public String uplodedFile(@RequestParam("wordFile") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			return "demo";
		}

		try {
			
			XWPFDocument doc = new XWPFDocument(file.getInputStream());
			PdfOptions pdfOptions = PdfOptions.create();
			OutputStream out = new FileOutputStream("C:/running/convertedFile.pdf");
			
			PdfConverter.getInstance().convert(doc, out, pdfOptions);
			doc.close();
			out.close();

		} catch (IOException e) {
			// TODO: handle exception
		}

		return "NextPage";
	}
}
