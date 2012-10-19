2) cd into the directory that matches your application name
	
	cd <your app name>
	
3) add this git repository to your application
	
	git remote add upstream -m master git://github.com/thesteve0/mailreflector.git

4) merge this repository into your application

	git pull -s recursive -X theirs upstream master
	
5) Modify the code and push back up to your OpenShift gear

	git push
	
