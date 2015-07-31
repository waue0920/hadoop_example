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
for i in $(ls ./*.CSV ) ;do iconv -c -f big5 -t utf8 $i -o $i".utf8";done
mv *.utf8 ../input/
cd ../input/
rm *_BUILD.CSV.utf8
rm *_LAND.CSV.utf8
rm *_PARK.CSV.utf8
cd ../
