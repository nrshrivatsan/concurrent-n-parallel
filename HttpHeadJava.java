import java.util.*;
import java.util.concurrent.*;
import static java.util.Arrays.asList;
import java.net.*;
import java.io.*;

public class HttpHeadJava {

    private static Map<String,Long> urls = new HashMap<String,Long>();
    static{
        urls.put("http://ppcdn.500px.org/53472962/016dc8008e0e1b0a71437a18ec4ef502c0e69cf6/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53498178/0d13aa906538a8021568b948edfe3a3b3343dcf2/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53495988/69d5a868beb9a4610e06ad1d64efa10204f8f45c/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53488670/be88ee3404909ffb5e0f058133c8cb3cb3c61582/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53472200/d23ece8bf9ab2f405b396edaf38a6ef77aab0c1e/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53450310/977ea22beefa8c7148b3155bd829209a3ccf3330/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53503408/5ed549003f8e919a3bf4b55f1e47dfa76ff77218/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53496530/4a724f69bb4c1cb5e890594967572584f0c405cc/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53493274/d55f2a1c0e639888d2ac7f20c04d360a18a75511/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53478682/60a97a27221b471a00d2ea4c8a080cdf05350865/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53472206/c99f0f1329f9ba908080cfb20def5fae433163da/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53470904/5b99c63c3f1d1d19e01e73f49e88d72dc5776dca/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53487620/514a8bb11650e53a25295e05f13e76069ffe982f/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53471946/eb4244d152527e5f28199e0f822ffb6f9e7307a5/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53512606/b46b81f293c18870bc537eb29af41176c364b177/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53508262/b3f1845372b29b7721d45e16e8696e061a229e1c/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53502718/3b1ab7097f8f1c6e32034f363680c1e08a37ab73/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53499444/af5315c17755f7cfcc2c58023ecb553984882ce6/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53497032/eb94e8f8780d3aca740d5e53ad0585419bb792d9/5.jpg",null);
        urls.put( "http://ppcdn.500px.org/53481666/58ab7f6db578f75f2b9e1da485b180acebd8b8a9/5.jpg",null);
        urls.put("http://ppcdn.500px.org/70721915/3eb30b1c45f08d195e5fb312a518f33b537c11eb/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70726687/2ac2412da44675553f01752b2114284dfe85f6f8/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70718909/f984dffdee1b0f02875c2786af4e0da670d7dcf1/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70713787/418a6b72383e5c156d669e7196d0c814e4daac3a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70714061/0f2e11a9063b3f2aa30a539a7c476ed52cd96783/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70771729/fccad2f44bfc98ec945b3f063b70bfc46ebed5fa/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70702681/b9b2f2f7d9f852a0fa48b4ab517193a7ffd906d0/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70721711/b378247442d73e1d2953c0b10e775f458b342ab9/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70733203/9679f59c8688388b30c546e4dc37c3386a1442b2/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70703413/3090424cb5c4510bbb82a87adef284de83e20bf2/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70751593/ccd461c2e39ed081ed98b6cd06be222abab23353/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70704449/2aadc988d71607b75f3e1cecba9cde4fd4269e54/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70704135/1e0648eb0b502d90267838b1559cd5ab89d75480/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70715339/6e2d2cb3497b199e1b630ae42268b29ab676520e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70703935/0c0da7769748463b30b15a6f005646e9d6356a72/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70760071/111f506053e58756901119c2fb3ecde05fc05ce4/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70754099/3849860e4ebd29d5b606b74d36087701c541eaca/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70717807/01dc395bca0cd9669edf2a6341f96dd7b4c43832/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70715009/5337a9ece620f63d5e74fc0fcb5e051ebb2edc43/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70755745/6345856ecc57e84d70083713d2f86adc1037a5c4/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70714697/b8324a778e386f7fd5dd0cd66d5e06c7d916c572/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70762655/ea641a26eef43d637babdca1f63e5624c0107245/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70783881/a8ec6bf33b6a9c9d059be9bbb8379494ce76f539/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70781997/f9d997aed2d2a7b943462e495f83762c63b50f14/3.jpg?v=1",null);
        urls.put("http://ppcdn.500px.org/70753801/b79e427f94ed4bc176bb0ecd1b54fd4161bcd74f/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70710627/9c55c1f1a37a5371f743e7c193977e4d6cc3a14a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70749073/2c42f58382d2a9de476516d1651f0a1fc2cce9f6/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70716215/de10792fbf0a767b9d0839baafeb284855957378/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70705365/fb492e1ac735d095397903ec4b9e719f5509dcb4/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70756921/3be479d677e5530c795ac6e4e95a2e9ea247515a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70751187/f9757be724503e8eedc3e664a68e050e045777e0/3.jpg?v=1",null);
        urls.put("http://ppcdn.500px.org/70782011/4100667476cd75977fc38eb25c159c3f28249061/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70720053/4c86624113f18ffe77d18cbe214228e1e46531dc/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70704475/89376ee48d0fcad669cc1a3924f7682c57269ae7/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70702617/c475262d9b70226d8e204bff0558c0b36210359d/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70788885/0f95e3a21a94974ebf20fbfaec36821f7738821f/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70744957/f718cb54186c57455d88dd1f87f3f36840f8cd36/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70744923/7e706d3a4a7ea25603eb4e3c32396a8e7b249586/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70741417/c37c0a652a8f9df8ae5de1d7923f00b1dfc38a61/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70701613/b1aa3c63184ad27892ab3b7abd027b244da99f9e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70700869/241d5b287432a29e6e02d5131049dcc346562c5c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70766635/a38df7e0af09b7146815fe4384613c1d3b4deb89/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70705731/6cee3dab54e72a5f0952248ee4184c76200e9dfa/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70719937/bfa9e8ba1b0184f9703f992bad3504730c926b79/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70723557/3e0f457a26e072ce54cffaa63975cc707b64244b/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70761437/6a42868be3167dc165612f526f57dd5b470331b3/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70745329/72128512601aaadc2259de6f9d36febdcec0b82c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70722451/2e8d01a9bd394b35b154e9895061ce2d94abb916/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70722239/0b47072be893adafb5475770ca52ad5b9347e430/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70705333/bae4f691c2f3c2b8f0189b81011d0d2d14e58227/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70771513/951d841994ff7d71955f04f44cfb3f7c58c30756/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70743827/1ea9e6fd8694fc22d3f599fdaa9159241ad6153f/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70720369/8b4cd01db2aa72f6c6a77074144dc06ce19cbc71/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70719121/522a869342d19f83796d6412ca383bd3d4b6f22a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70718487/d78fc7c698258b7df188627b47825a4a8c739591/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70770023/5568c8ebce533d979cbb3c3c2d2d2863248832ad/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70719555/5e99e184ba72d43eab6d61e885586f8e88a9ea2a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70768141/70c4422c72cf23b262213a01a78590f432c5b557/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70739601/2547ddd728ba5cb64be22ae7a1ce3551058eade2/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70727927/399e98502bb6bc8484f8751edae57a868fb60e83/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70792249/3c02eac529e49befa3247a4fefc59d3e7cfe69c0/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70754323/8564121a864c8062860d495a87413baf3113004c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70763795/0e093da9cf8f3aac27e00828017cbcda8517fd38/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70750625/6bbc3dfa9228fc7387780cb1459ce75c42f35b90/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70746143/f9cb01f4f1adaad2e84eae529c8e26e452116d1c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70768863/cab43156d2557f39bab32b8d2c37747070101c88/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70734475/2bc697a00d6eaac531edab35c93ab67e6023e7a6/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70705537/9d5ef335f278358851b659492e3f93d267187a0c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70785229/7d67b71791f4766937acf6fb84e3f65891100a81/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70777199/2669acb4e7df78a44070cac12466cc257d8eb5e2/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70750645/b6742de9da3bb233140277fad9fde2c8b7cd86e0/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70742293/0b067ee182b7d0660672b4aa2069e6c7dc3bfe50/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70765621/027ffcfddaf0da3801e700151aa202465f4f9061/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70762733/fb923dfe5b6c745f07ea23d8f1cc7dbbb910b5e4/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70752643/6eeb45c5274b3e3548ad97b4a94cf97e0a273611/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70736559/f3f6ac30004b3ebbffd0c00cbbdfdcaa4dc805ff/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70721779/830df214942c00a9481a77356db8cc49f12b1b03/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70716835/fe3b10828b3c434c1513f531fa5d61b25bf54e6c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70706581/fb95ac41a4a440bc2bd1fbda2e0cdd85cd7ac05a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70702403/8ea281ce1e01fdd634cf4fe14c433b44331c6246/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70765521/f8066e7fdcac8d8d233d5f2e80044154e6a35a6a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70720019/6f9ad41856e5d3edca8b77206424ba2bf64bd6fa/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70707973/4474eb1253877b4d4eba021c2d3315426a9a34b9/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70703689/3351279e21e0416bac8149c1c37e009f53b24b3e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70754177/d56e05988cf6bc92226502d0531b7c574d9baedb/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70740285/5c7f3a4d9d70ff0941c46d1b4536cdc8b9c23ba7/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70728519/1fe9a25e5e82b7d2835cfc79d96dd8b7e364a672/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70724181/301b100a8a4235a93adc26d6c3281f7d2e46c412/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70720465/dd2bb43c67ae1a8bd921c6bc3350fa87e493d3a7/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70713229/86dda2776e43f989f2c0febe32bbeb3b835fad0e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70765411/2e8639e41749dcc8ca9fbd31a8849c1e2146ed9d/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70747141/1ec28b26dce51dfdcce588201d81a29ac5a8eb49/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70783483/dd3ddf724364510e6f046ce92d591e961798f03e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70759125/a460b183bcd1245b553f3bf9d95f5d6043648ca0/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70751389/86de443a3145dd844b89b8232ef4f6ecb1d7ca7c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70744571/8b7953e85ee7eb16624fd08f8cd5b0d369015de8/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70717281/32776970d4e49a448cb1338750deec96cd96a0c6/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70707843/2a17bafaf55888d4bc8b075056bf91565252170d/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70727519/27ac2ae983a39b84a5a742867b322447fca61b90/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70716413/6770996560a23a8f31cfbd010799665991038102/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70782743/06f1a8fcb873ec8ea6bc3e32463354578e794c47/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70768459/c095880b2ed6811df077d7e6aaea37e67aeee338/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70719891/2a558043ae9ade23db8b2ddfd410355bd545187c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70786877/f26bb2e94dd5edc89cc90950fe2189c32557d5e6/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70780799/2ca966efbb58b4c5f21cd828a55213e14b75ff38/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70754613/403c013040e549652d5660e1d0ceb40933b051e1/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70727739/97b68f654877339c54f561a5ead8bdaa30ba048d/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70783149/e7db525735430ae08cdce8c7a09b883d7a75594b/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70783527/2af41642682144f69690fb9b2b9afe1016d3c344/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70781345/bcc0d67da547029f15c610259717ef8e58c75fed/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70779183/75d41437c022a51ab5a6ee7802c8bdd7557e8566/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70775051/d196bcdd49d1025d7e944d12ac536a623802e789/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70751739/be3813d9e54a065e958823c8cb9b32a0b24a4151/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70702053/efcbed33d504bda2d6d3172fc62f13659a1515c8/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70730857/b40605169692965cecab66bc65e7dd2e2df7e4fe/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70722049/75dd591dc1c24556ddf4c182f97fef8d4f1189a3/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70717279/2ed9b2da54c752ee9e2c1a9a7522b5ed8029d8fd/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70784833/93354fea280861d413b1ae17bd6fecad4ee59dc9/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70752325/cb8f83ea0dbe412c31a01637bceb2f8558a3016f/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70740385/670011deb6fc982509cd30fd4eec7a0334b1308e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70783901/b252b6a09c296bcc7ba194cb189f9c648fda1df4/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70753471/0f4c9f8a41984672fa880d3bb9a66ebd59003450/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70718185/a1c3414d6450f8e0233e5685178f21ca0b8b463c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70712567/b4dc5182b0d0d76c0ad5ea054595a49915ab9c09/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70712385/faa7002a257cbae72a6a11cba2192af7a0f53989/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70709021/40a1cf255b0ef3261a27c46a31ccebdec9f0086e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70756311/f0a555cc829a598fc217f6895a9e8444e3f89d41/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70732517/4051532ea690b721e044f988dc11925bdaac20d5/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70710571/26e91bd0496ed76d4507f061931fdde34a8c338d/3.jpg?v=1",null);
        urls.put("http://ppcdn.500px.org/70759875/6a0577e9ee0b60e0d32c5ab0e5f3cf40215cd576/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70749513/5af1bfba7df7bcead8cd91f91fb6c7b74445da6a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70745287/ce13572a9ffb07ee01184bdf197b4ae486984e7a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70734887/c6885b75b10d9aff4c9367d8bbe787166497f3c0/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70733695/2d74b98d5c88f8b5aae75224fa97c3f88b1b47f5/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70719163/cff527e1a8ce367d9c66a31713c02a41c91b5b0e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70769429/0cee1d1f5125eebed02565746a32930748612d02/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70749619/570aac5173ac452b5ff0a26f448318ccd0950601/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70733941/1c539913b3e8bede4213ba74ec2227b980e5f104/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70728767/156e6eb9461c60649aaa945fcfea29b5714fbd68/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70723769/d482b5ed5e03d96b8a65591dbabccb759fd1be3f/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70771411/0a5609afcb051b7d87e539afe1f129bdbc13efcc/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70763055/00b2795eb3f361340be0edd49fb37c1895006686/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70746511/1e29d38e0cbbe24eb2445e246e862c4f16f47e59/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70702047/20f6af6e6e231780f8c3c323781f55e8d83e2a1e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70781983/ef8f38abbe1e63ac4f981a2e1faded12c5b90963/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70761583/6e541ec2ebc1eb66ac22dc4a9ffd3957c9b1476a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70756271/0ebd9933a60ff8bab24aed36e4d2fe4333d96e27/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70724179/e304ac817d97f82e344be601fef35dab4dd34ac1/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70719179/282de8b73330d04b522234f51b18fbb2511ff47c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70707825/9e0d85203b19be0d8942dbf05c5d6edc34df55fc/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70740353/c6e4a64e09d172af7e9babdca0f20ba852561965/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70718821/7a4f08c563bc79f4619be5b0b748021f328fccb7/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70713953/279d92e43bf6a2c17c60ea55e90fded71c8b62d2/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70788961/22bf4460405ade7578340eda4a06f41a6d263815/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70770503/ec66b0502345a2b93fc98c5ffa9aaf193a63546a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70753303/652456bfda765a2868a870e89fdae1145532f410/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70745357/d012e93fe657b37718da2e8b84bb848600829b6d/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70720849/ca79ff055a08f32bc68c404203804eb00d1e8d80/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70709901/e1519194db91015c79812f14897e4370703457b8/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70784737/1b865411a4cbf3edb63c8860d471e86cea778963/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70760839/213e1578ca298e57c6cc5c44fdaa56edaeea43fb/3.jpg?v=1",null);
        urls.put("http://ppcdn.500px.org/70754525/1f5b470ac59f4e4f1ae7dce3223cae00602ae48a/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70747835/055aa254a74a1d0635267f4d26e3b8e868094410/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70744671/6b9691f2e0f8601f8d751f7677ae8f8050cc1b5e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70752587/6dafc253c3ae0b0c1ac63bf98fc9d4c08af8d6c0/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70763773/897d583170c0a1a4c7531de04e8c33239f5df4d9/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70716249/582fddd4707cd8dff17fc24e1060ea038d4bfa3d/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70779347/cdf5cc5c476c32575aa85c41d91baa5c1911016c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70772047/f45a9289dedcd227e4a1fe1e7a1047cb8f6252db/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70770517/9af51f505c90b2c7b0f26c932f83801ebe727342/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70767977/4ca25bb4d6e22ef004519ffa830124482d2b1930/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70759801/5a47fb5369e41d253428c15a40f873d78d2f0df4/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70746593/42bb9e7b811b77668e32d8bb3410d6dbc1d95042/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70746251/91c4cc678910f5b31b97a804e2e6f74e92cb9a77/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70717827/50ab9171b33a3c6863d47fbada7a5df0716fa97f/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70796331/8d8d199694baa6255fe616f66a3fb54eac55649e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70773579/a52503cfae13240f2955ac6c96d3e528811b47dd/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70757689/606e791ff97f894225e89ac35cff791f61b733bd/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70751719/415148f1d4785477fb3851b348cf626266750fa7/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70742513/2dac9e9567d777f3a72bb610cd1c50ef0a098d32/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70755425/d99ce3c72c33e2d09fa607924a59ca5fdb0c2b4e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70755321/d68b71f387e7fa8483e669d60c399e0c8fa5e2a9/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70755027/d1c3d202601d3f0cf9402c19cdf14be30763cfd8/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70743709/e6263dea2929d573560c3ab7f757db614a72659d/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70724513/6edefa7f15b47eaa39e3941e25402484e963e31e/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70722215/6f32349bfdacea1ab9b4a0cef179bc9a6d20f89c/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70711639/408ebbc6fae3f18c83806daf4665b67ca78fbf34/3.jpg?v=0",null);
        urls.put("http://ppcdn.500px.org/70793699/7ee733e2d3f4f9104a025adfe30602ba24571ece/3.jpg?v=0",null);
    }

    static class Hitter implements Callable<Map<String,Integer>> {
        
        private String url;

        public Hitter(final String url){
            this.url = url;
        }
        
        @Override
        public Map<String,Integer> call() {            
            return exists(this.url);
        }              

        public Map<String,Integer> exists(String URLName){
            Map<String,Integer> data = new HashMap<String,Integer>();
            try {
              // HttpURLConnection.setFollowRedirects(false);            
              HttpURLConnection con =
                 (HttpURLConnection) new URL(URLName).openConnection();
              con.setRequestMethod("HEAD");
              data.put(url,con.getContentLength());
              return data;
            }
            catch (Exception e) {
               e.printStackTrace();
               return null;
            }
        }
    }

   
    public static void main(String[] args) throws Exception {                

        ExecutorService executor = Executors.newFixedThreadPool(2);        
        List <Future<Map<String,Integer>>> results;
        List<Callable<Map<String,Integer>>> callables = new LinkedList <Callable<Map<String,Integer> >>();
        for(String url : urls.keySet()){            
            callables.add(new Hitter(url));
        }

        results = executor.invokeAll(callables);

        executor.shutdown();
        
        for (Future<Map<String,Integer> > result : results) {
            System.out.println(result.get().toString());
        }                
        new Scanner(System.in).next();
    }    
}