File.prototype.convertToBase64 = function(callback){
        var FR = new FileReader();
        FR.onload = function(event) {
             //callback(event.target.result)
             callback(btoa(event.target.result))
        };       
        //FR.readAsDataURL(this);
        FR.readAsBinaryString(this);
};

function base64toBlob(base64Data, contentType) {
    contentType = contentType || '';
    var sliceSize = 1024;
    var byteCharacters = atob(base64Data);
    var bytesLength = byteCharacters.length;
    var slicesCount = Math.ceil(bytesLength / sliceSize);
    var byteArrays = new Array(slicesCount);

    for (var sliceIndex = 0; sliceIndex < slicesCount; ++sliceIndex) {
        var begin = sliceIndex * sliceSize;
        var end = Math.min(begin + sliceSize, bytesLength);

        var bytes = new Array(end - begin);
        for (var offset = begin, i = 0 ; offset < end; ++i, ++offset) {
            bytes[i] = byteCharacters[offset].charCodeAt(0);
        }
        byteArrays[sliceIndex] = new Uint8Array(bytes);
    }
    return new Blob(byteArrays, { type: contentType });
}

function onChangeURLDaFotoNoGoogleDrive(inputElement) {
	
	var urlDaFotoNoGoogleDrive = inputElement.value;
	
	if (urlDaFotoNoGoogleDrive.indexOf("https://drive.google.com") != -1) {
	
		var codigo = urlDaFotoNoGoogleDrive.replace("https://drive.google.com/file/d/","")
										   .replace("/view?usp=sharing","");
		
		var novaUrl = "https://drive.google.com/uc?export=view&id=" + codigo;
		
		inputElement.value = novaUrl;
	}
};