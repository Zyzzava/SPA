package com.zyzzava.SPA;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class SpaApplication extends JFrame {
	public SpaApplication() {
		final String url = "https://www.investing.com/crypto/currencies";

		try {
			final Document document = Jsoup.connect(url).get();

			Element table = document.select("table").first();
			Elements rows = table.select("tr");

			String[] columnNames = {
					"Rank",
					"Name",
					"Symbol",
					"Price",
					"Market Cap",
					"Volume 24H",
					"Total volume",
					"Change 24H",
					"Change 7D"
			};

			// Create an empty ArrayList to hold the data
			List<CryptoCurrency> data = new ArrayList<>();

			System.out.println("Number of rows: " + rows.size());
			System.out.println(rows.get(0).text());
			System.out.println(rows.get(1).text());

			for(Element row : rows) {
				// Elements columns = row.select("td");
				String[] columns = row.text().split(" ");
				String rank = columns[0];
				String name = columns[1];
				String symbol = columns[2];
				String price = columns[3];
				String marketCap = columns[4];
				String volume24H = columns[5];
				String totalVolume = columns[6];
				String change24H = columns[7];
				String change7D = columns[8];

				CryptoCurrency currency = new CryptoCurrency(rank, name, symbol, price, marketCap, volume24H, totalVolume, change24H, change7D);

				data.add(currency);
			}
			//Delete first entry in data
			data.remove(0);
			System.out.println("Number of currencies: " + data.size());

			// Create a 2D array to hold the table data
			Object[][] tableData = new Object[data.size()][columnNames.length];
			for (int i = 0; i < data.size(); i++) {
				CryptoCurrency currency = data.get(i);
				tableData[i] = new Object[]{
						currency.getRank(),
						currency.getName(),
						currency.getSymbol(),
						currency.getPrice(),
						currency.getMarketcap(),
						currency.getVol24H(),
						currency.getTotalVol(),
						currency.getChg24H(),
						currency.getChg7D()
				};
			}

			// Create the JTable
			JTable tableComponent = new JTable(tableData, columnNames);

			// Create a scroll pane to hold the table
			JScrollPane scrollPane = new JScrollPane(tableComponent);

			// Create a panel to hold the scroll pane
			JPanel panel = new JPanel();
			panel.add(scrollPane);

			// Set up the frame
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Crypto Currencies");
			add(panel);
			pack();
			setLocationRelativeTo(null); // Center the frame on the screen
			setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SpaApplication();
	}
}
