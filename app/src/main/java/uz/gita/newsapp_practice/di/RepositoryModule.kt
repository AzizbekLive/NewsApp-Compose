package uz.gita.newsapp_practice.diimport dagger.Bindsimport dagger.Moduleimport dagger.hilt.InstallInimport dagger.hilt.components.SingletonComponentimport uz.gita.newsapp_practice.data.repository.NewsRepositoryImplimport uz.gita.newsapp_practice.domain.repository.NewsRepositoryimport javax.inject.Singleton@Module@InstallIn(SingletonComponent::class)interface RepositoryModule {    @[Binds Singleton]    fun bindsRepository(impl: NewsRepositoryImpl): NewsRepository}