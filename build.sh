mkdir build
git clone https://github.com/AwesomeSauceMods/AwesomeSauceCore.git build/src
git clone https://github.com/AwesomeSauceMods/CoolInfoStuff.git
mv CoolInfoStuff/* build
cd build
rm -r OpenAutomation
mkdir SoulBound
cd SoulBound
git clone https://github.com/AwesomeSauceMods/SoulBound.git src
cd ..
bash gradlew setupCiWorkspace
bash gradlew SoulBound:build
#