package info.toyonos.hfr4droid.common.core.data;

import info.toyonos.hfr4droid.common.core.bean.AlertQualitay;
import info.toyonos.hfr4droid.common.core.bean.Category;
import info.toyonos.hfr4droid.common.core.bean.Post;
import info.toyonos.hfr4droid.common.core.bean.Profile;
import info.toyonos.hfr4droid.common.core.bean.SubCategory;
import info.toyonos.hfr4droid.common.core.bean.Topic;
import info.toyonos.hfr4droid.common.core.bean.Topic.TopicType;

import java.util.List;

/**
 * <p>Interface définissant le moyen de récupérer des données sur un forum
 * de discussion MesDiscussions.net</p>
 * 
 * @author ToYonos
 * @see info.toyonos.core.bean.Category
 * @see info.toyonos.core.bean.Topic
 * @see info.toyonos.core.bean.Post
 *  
 */
public interface MDDataRetriever
{
	/**
	 * Récupére le hash check courant
	 * @return Le hash check dans une <code>String</code>
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public String getHashCheck() throws DataRetrieverException;
	
	/**
	 * Récupére l'url de base du forum
	 * @return L'url de base du forum sous forme de <code>String</code>
	 */
	public String getBaseUrl();
	
	/**
	 * Récupére l'url des images perso du forum
	 * @return L'url des images perso du forum sous forme de <code>String</code>
	 */
	public String getImgPersoUrl();

	/**
	 * Récupére les catégories
	 * @return Une <code>List</code> de <code>Category</code>
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public List<Category> getCats() throws DataRetrieverException;
	
	/**
	 * Récupére une <code>Category</code> par son code
	 * @param code Le code de la catégorie
	 * @return La <code>Category</code> trouvée ou null si elle n'existe pas
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public Category getCatByCode(String code) throws DataRetrieverException;
	
	/**
	 * Récupére une <code>Category</code> par son id
	 * @param id L'id de la catégorie
	 * @return La <code>Category</code> trouvée ou null si elle n'existe pas
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public Category getCatById(long id) throws DataRetrieverException;
	
	/**
	 * Récupére les sous catégories d'une catégorie
	 * @param cat La <code>Category</code> désirée
	 * @return Une <code>List</code> de <code>SubCategory</code>
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public List<SubCategory> getSubCats(Category cat) throws DataRetrieverException;
	
	/**
	 * Indique si les <code>SubCategory</code> d'une catégorie donnée sont chargés
	 * @param cat La catégorie ciblée
	 * @return true les sous catégories sont chargées, false sinon
	 */
	public boolean isSubCatsLoaded(Category cat) throws DataRetrieverException;
	
	/**
	 * Récupére une <code>SubCategory</code> par son id
	 * @param cat La catégorie ciblée
	 * @param id L'id de la sous-catégorie
	 * @return La <code>SubCategory</code> trouvée ou null si elle n'existe pas
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public SubCategory getSubCatById(Category cat, long id) throws DataRetrieverException;
	
	/**
	 * Récupére les topics d'un type donné d'une catégorie
	 * @param cat La <code>Category</code> désirée
	 * @param type Le type de topic (tous, drapeaux cyan, drapeau rouges ou favoris)
	 * @return Une <code>List</code> de <code>Topic</code>
	 * @throws DataRetrieverException Si un probléme survient
	 * @see #getTopics(Category, TopicType, int)
	 */
	public List<Topic> getTopics(Category cat, TopicType type) throws DataRetrieverException;

	/**
	 * Récupére les topics d'un type donné et de la page donnée d'une catégorie
	 * @param cat La <code>Category</code> désirée
	 * @param type Le type de topic (tous, drapeaux cyan, drapeau rouges ou favoris) 
	 * @param pageNumber Le numéro de la page
	 * @return Une <code>List</code> de <code>Topic</code>
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public List<Topic> getTopics(Category cat, TopicType type, int pageNumber) throws DataRetrieverException;

	/**
	 * Marque une page de topic comme lu
	 * @param topic Le <code>Topic</code> désiré
	 * @param pageNumber Le numéro de la page
	 * @return true si tout s'est bien passé, false sinon
	 * @throws DataRetrieverException
	 */
	public boolean setPostsAsRead(Topic topic, int pageNumber) throws DataRetrieverException;
	
	/**
	 * Récupére les posts de la page donnée d'un topic
	 * @param topic Le <code>Topic</code> désiré
	 * @param pageNumber Le numéro de la page
	 * @param useFakeAccount Utiliser ou pas un faux compte pour ne pas altérer les drapeaux
	 * @return Une <code>List</code> de <code>Post</code>
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public List<Post> getPosts(Topic topic, int pageNumber, boolean useFakeAccount) throws DataRetrieverException;
	
	/**
	 * Récupére les posts de la page donnée d'un topic en utilisant le vrai compte de l'utilisateur
	 * @param topic Le <code>Topic</code> désiré
	 * @param pageNumber Le numéro de la page
	 * @return Une <code>List</code> de <code>Post</code>
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public List<Post> getPosts(Topic topic, int pageNumber) throws DataRetrieverException;
	
	/**
	 * Cherche les posts d'un topic donné selon des critéres
	 * @param topic Le <code>Topic</code> désiré
	 * @param pseudo L'auteur des posts recherchés
	 * @param word Le mot contenu dans les posts recherchés
	 * @param fromPost Le premier post é partir duquel la recherche doit s'effectuer, non inclus dans les résultats (null si depuis le début)
	 * @return Une <code>List</code> de <code>Post</code>
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public List<Post> searchPosts(Topic topic, String pseudo, String word, Post fromPost) throws DataRetrieverException;

	/**
	 * Donne le nombre de nouveaux mps
	 * @param topic Référence d'un topic. Si un seul nouveau mp existe, il sera renvoyé par ce biais
	 * @return Le nombre de nouveaux mps
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public int countNewMps(Topic topic) throws DataRetrieverException;

	/**
	 * Récupére les smileys é insérer dans un post
	 * @param tag Le tag des smileys recherchés
	 * @return Le code HTML des smileys trouvés
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public String getSmiliesByTag(String tag) throws DataRetrieverException;

	/**
	 * Récupére le BBCode d'un post é quoter
	 * @param post Le post concerné
	 * @return Le BBCode obtenu
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public String getQuote(Post post) throws DataRetrieverException;

	/**
	 * Récupére le BBCode d'un post é éditer
	 * @param post Le post concerné
	 * @return Le BBCode obtenu
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public String getPostContent(Post post) throws DataRetrieverException;
	
	/**
	 * Récupére les mots clés d'un smiley
	 * @param code le code du smiley
	 * @return Les mots clés obtenus
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public String getKeywords(String code) throws DataRetrieverException;
	
	/**
	 * Récupére le profil d'un utilisateur
	 * @param pseudo son pseudo
	 * @return Le <code>Profile</code> de l'utilisateur
	 * @throws DataRetrieverException Si un probléme survient
	 */
	public Profile getProfile(String pseudo) throws DataRetrieverException;
	
	/**
	 * Récupére la vraie url rewrittée par le forum (suite é un code 301)
	 * @param url L'url de base
	 * @return L'url vers laquelle on est redirigé, ou null si on obtient un code différent de 301
	 * @throws DataRetrieverException
	 */
	public String getRealUrl(String url) throws DataRetrieverException;
	
	/**
	 * Récupére les alertes qualitaé d'un topic donné
	 * @param topic Le topic concerné
	 * @return  Une <code>List</code> d'<code>AlertQualitay</code>
	 * @throws DataRetrieverException
	 */
	public List<AlertQualitay> getAlertsByTopic(Topic topic) throws DataRetrieverException;
}