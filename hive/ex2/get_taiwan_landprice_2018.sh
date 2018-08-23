bin=`dirname "$0"`
bin=`cd "$bin"; pwd`
cd $bin;
rm -rf source;
rm -rf input;
mkdir source; 
cd source
wget "http://plvr.land.moi.gov.tw//Download?type=zip&fileName=lvr_landcsv.zip" -O lvr_landcsv.zip
unzip lvr_landcsv.zip 
mkdir ../input; 
mv *.CSV ../input
cd ../input/
rm *_BUILD.CSV
rm *_LAND.CSV
rm *_PARK.CSV
rm SCHEMA*.CSV
rm MANIFEST.CSV
cd ../
