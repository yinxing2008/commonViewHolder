# commonViewHolder
recyclerView统一通用adapter和viewHolder
# 特点：
1.使用recyclerView时， 不再需要自己增加adapter和viewHolder了。
# 调用样例：
1. 工程根目录下build.gradle文件添加：
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```
2. app工程下build.gradle文件添加依赖：
```
dependencies {
	        implementation 'com.github.cxyzy1:commonViewHolder:0.0.2'
	}
```
3. 调用样例：
```
List<String> data = prepareData();
RecyclerView recyclerView = findViewById(R.id.recyclerView);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(prepareAdapter(data));

private SimpleCommonAdapter<String> prepareAdapter(List<String> data) {
        return new SimpleCommonAdapter<String>(data, android.R.layout.simple_list_item_1) {
            @Override
            protected void onBindViewHolder(ViewHolder holder, String data, int position) {
                holder.setText(android.R.id.text1, data)
                        .setTextColor(android.R.id.text1, Color.RED)
                        .setOnItemClickListener((view) ->
                                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show()
                        );
            }
        };
    }
	
private List<String> prepareData() {
    List<String> data = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
        data.add("text-" + i);
    }
    return data;
}
```

