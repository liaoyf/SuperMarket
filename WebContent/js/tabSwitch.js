function tabSwitch(_this,content_prefix,active){
	var tabs = document.getElementsByName(_this.name);
	var number = tabs.length;
	for(var i=0;i<number;i++){
		var tab = tabs[i];
		tab.className = "";
		document.getElementById(content_prefix+i).style.display = 'none';
	}
	_this.className="tab-active";
	document.getElementById(content_prefix+active).style.display = 'block';
}